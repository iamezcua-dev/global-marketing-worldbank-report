package com.autoscheduler.model

import com.fasterxml.jackson.annotation.JsonProperty

import scala.beans.BeanProperty

case class Information( @BeanProperty @JsonProperty( value = "indicator" ) indicator: Indicator,
                        @BeanProperty @JsonProperty( value = "country" ) country: Country,
                        @BeanProperty @JsonProperty( value = "countryiso3code" ) countryiso3code: String,
                        @BeanProperty @JsonProperty( value = "date" ) date: String,
                        @BeanProperty @JsonProperty( value = "value" ) value: String,
                        @BeanProperty @JsonProperty( value = "unit" ) unit: String,
                        @BeanProperty @JsonProperty( value = "obs_status" ) obs_status: String,
                        @BeanProperty @JsonProperty( value = "decimal" ) decimal: String ) {
  def this( ) = this( Indicator( "", "" ), Country( "", "" ), "", "", "", "", "", "" )
}

