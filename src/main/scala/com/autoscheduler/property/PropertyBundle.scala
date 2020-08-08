package com.autoscheduler.property

import java.beans.BeanProperty

import javax.validation.constraints.NotNull
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties( "application.properties" )
class PropertyBundle( ) {
  @BeanProperty
  @NotNull var populationGrowthRateIndicatorBaseUrl: String = _
  @BeanProperty
  @NotNull var yearRange: String = _
}
