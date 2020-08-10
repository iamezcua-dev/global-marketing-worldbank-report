package com.autoscheduler.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Embeddable

import scala.beans.BeanProperty

@Embeddable
case class Country( @BeanProperty @JsonProperty( value = "id" ) countryId: String,
                    @BeanProperty @JsonProperty( "value" ) countryValue: String ) {
  
  def this( ) = this( "", "" )
  
}