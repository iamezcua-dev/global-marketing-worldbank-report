package com.autoscheduler.controller

import java.util.Locale
import java.util.Locale.IsoCountryCode

import com.autoscheduler.service.WorldPopulationGrowthService
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
class WorldPopulationGrowthController( ) extends LazyLogging {
  
  @Autowired()
  var service: WorldPopulationGrowthService = _
  
  @RequestMapping( value = Array( "/results" ), method = Array( RequestMethod.GET ) )
  def retrieveData( ): Unit = {
    service.getInformation
  }
  
  @RequestMapping( value = Array( "/indicators" ), method = Array( RequestMethod.GET ) )
  def getAndStoreWorldsPopulationGrowth( ): Unit = {
    Locale.getISOCountries( IsoCountryCode.PART1_ALPHA3 )
        .toArray.map( _.toString )
        .map( country => {
          val countryStatisticsList = service.getWorldPopulationGrowth( country )
          logger.info( s"$countryStatisticsList" )
          countryStatisticsList
        } )
        .foreach( countryStatistics =>
          service.saveStatisticsToDatabase( countryStatistics ) )
  }
  
  @RequestMapping( value = Array( "/sample" ), method = Array( RequestMethod.GET ) )
  def getData: String = {
    service.getSampleData
  }
}
