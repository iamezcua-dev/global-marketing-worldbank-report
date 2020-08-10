package com.autoscheduler.controller

import com.autoscheduler.service.WorldPopulationGrowthService
import com.autoscheduler.utils.Helper
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
  def getAndStoreWorldsPopulationGrowth( ): String = {
    Helper.getISOCountries().map( _.toString )
        .map( country => {
          val countryStatisticsList = service.getWorldPopulationGrowth( country )
          logger.info( s"$countryStatisticsList" )
          countryStatisticsList
        } )
        .foreach( countryStatistics =>
          service.saveStatisticsToDatabase( countryStatistics ) )
    "Job done!"
  }
  
  @RequestMapping( value = Array( "/sample" ), method = Array( RequestMethod.GET ) )
  def getData: String = {
    service.getSampleData
  }
}
