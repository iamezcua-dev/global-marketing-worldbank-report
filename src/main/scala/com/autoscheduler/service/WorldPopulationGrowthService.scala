package com.autoscheduler.service

import com.autoscheduler.model.Information
import com.autoscheduler.property.PropertyBundle
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.{ DeserializationFeature, ObjectMapper }
import com.fasterxml.jackson.module.scala.{ DefaultScalaModule, ScalaObjectMapper }
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class WorldPopulationGrowthService @Autowired()( properties: PropertyBundle ) extends LazyLogging {
  
  def getSampleData: String = "Sample"
  
  def getWorldPopulationGrowth( countryId: String ): List[ Information ] = {
    var populationGrowthByCountry = List.empty[ Information ]
    val url = String.format( properties.populationGrowthRateIndicatorBaseUrl, countryId, properties.yearRange )
    logger.info( s"Formed REST API url $url" )
    val restTemplate = new RestTemplateBuilder().build()
    val response = restTemplate.getForEntity( url, classOf[ String ] )
    
    if ( response.getStatusCode == HttpStatus.OK ) {
      try {
        logger.info( "********** JSON Response **********" )
        val jsonResponse = response.getBody.substring( response.getBody.indexOf( ",[" ) + 1, response.getBody.length - 1 )
        logger.info( s"Curated JSON: ${jsonResponse}" )
        val om = new ObjectMapper() with ScalaObjectMapper
        om.registerModule( DefaultScalaModule )
        om.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false )
        populationGrowthByCountry = om.readValue[ Seq[ Information ] ]( jsonResponse ).toList
      } catch {
        case jsonException: JsonParseException => println( jsonException.printStackTrace() )
      }
    }
    
    // If no data was received or an error ocurred, an Empty List will be returned :(
    populationGrowthByCountry
  }
  
}
