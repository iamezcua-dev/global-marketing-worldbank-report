package com.autoscheduler.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Embeddable

import scala.beans.BeanProperty


@Embeddable
case class Indicator( @BeanProperty
                      @JsonProperty( value = "id" )
                      idIndicator: String,

                      @BeanProperty
                      @JsonProperty( value = "value" )
                      valueIndicator: String ) {
  
  def this( ) = this( "", "" )
  
}