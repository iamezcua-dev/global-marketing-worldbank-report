package com.autoscheduler.controller

import java.util.Locale
import java.util.Locale.IsoCountryCode

import com.autoscheduler.model.Information
import com.autoscheduler.service.WorldPopulationGrowthService
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
class WorldPopulationGrowthController @Autowired()( service: WorldPopulationGrowthService ) extends LazyLogging {
  
  @RequestMapping( value = Array( "/indicators" ), method = Array( RequestMethod.GET ) )
  def getWorldsPopulationGrowth( ): List[ Information ] = {
    val countries = Locale.getISOCountries( IsoCountryCode.PART1_ALPHA3 ).toArray.map( _.toString )
    val countryData = countries.map( country => {
      val countryStatisticsList = service.getWorldPopulationGrowth( country )
      logger.info( s"$countryStatisticsList" )
      countryStatisticsList
    } )
    countryData.head
  }
  
  @RequestMapping( value = Array( "/sample" ), method = Array( RequestMethod.GET ) )
  def getData: String = {
    service.getSampleData
  }
}
