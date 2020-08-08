package com.autoscheduler.model

import com.fasterxml.jackson.annotation.JsonProperty

import scala.beans.BeanProperty

case class Country( @BeanProperty @JsonProperty( value = "id" ) id: String,
                    @BeanProperty @JsonProperty( "value" ) value: String ) {
  def this( ) = this( "", "" )
}