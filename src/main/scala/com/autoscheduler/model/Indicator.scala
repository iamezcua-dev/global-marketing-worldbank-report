package com.autoscheduler.model

import com.fasterxml.jackson.annotation.JsonProperty

import scala.beans.BeanProperty

case class Indicator( @BeanProperty @JsonProperty( value = "id" ) id: String,
                      @BeanProperty @JsonProperty( value = "value" ) value: String ) {
  def this( ) = this( id = "", value = "" )
}