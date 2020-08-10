package com.autoscheduler.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence._

import scala.beans.BeanProperty


@Entity
class Information( ) {
  @Id
  @GeneratedValue( strategy = GenerationType.AUTO )
  @Column( name = "id", unique = true, nullable = false )
  @BeanProperty
  var id: Integer = 0
  
  @BeanProperty
  @JsonProperty( value = "indicator" )
  @Embedded
  var indicator: Indicator = Indicator( "", "" )
  
  @BeanProperty
  @JsonProperty( value = "country" )
  @Embedded
  var country: Country = Country( "", "" )
  
  @BeanProperty
  @JsonProperty( value = "countryiso3code" )
  var countryiso3code: String = ""
  
  @BeanProperty
  @JsonProperty( value = "date" )
  var date: String = ""
  
  @BeanProperty
  @JsonProperty( value = "value" )
  var value: String = ""
  
  @BeanProperty
  @JsonProperty( value = "unit" )
  var unit: String = ""
  
  @BeanProperty
  @JsonProperty( value = "obs_status" )
  var obs_status: String = ""
  
  @BeanProperty
  @JsonProperty( value = "decimal" )
  var decimal: String = ""
  
  
  override def toString = s"Information($id, $indicator, $country, $countryiso3code, $date, $value, $unit, $obs_status, $decimal)"
}

