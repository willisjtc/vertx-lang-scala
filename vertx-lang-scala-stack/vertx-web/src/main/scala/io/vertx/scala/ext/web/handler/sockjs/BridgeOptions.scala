/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.web.handler.sockjs

import io.vertx.scala.ext.bridge.PermittedOptions
import io.vertx.scala.ext.web.handler.sockjs.{SockJSBridgeOptions => ExtSockJSBridgeOptions}
import io.vertx.ext.web.handler.sockjs.{BridgeOptions => JBridgeOptions}
import io.vertx.ext.bridge.{PermittedOptions => JPermittedOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Deprecated: use <a href="../../../../../../../../../cheatsheet/SockJSBridgeOptions.html">SockJSBridgeOptions</a> instead.

 */

class BridgeOptions(private val _asJava: JBridgeOptions) extends ExtSockJSBridgeOptions(_asJava) {
  override def asJava = _asJava
  override def setInboundPermitted(value: scala.collection.mutable.Buffer[PermittedOptions]) = {
    asJava.setInboundPermitted(value.map(_.asJava).asJava)
    this
  }

  override def addInboundPermitted(value: PermittedOptions) = {
    asJava.addInboundPermitted(value.asJava)
    this
  }

  override def getInboundPermitteds: scala.collection.mutable.Buffer[PermittedOptions] = {
    asJava.getInboundPermitteds().asScala.map(x => PermittedOptions(x))
  }

  override def setMaxAddressLength(value: Int) = {
    asJava.setMaxAddressLength(value)
    this
  }

  override def getMaxAddressLength: Int = {
    asJava.getMaxAddressLength().asInstanceOf[Int]
  }

  override def setMaxHandlersPerSocket(value: Int) = {
    asJava.setMaxHandlersPerSocket(value)
    this
  }

  override def getMaxHandlersPerSocket: Int = {
    asJava.getMaxHandlersPerSocket().asInstanceOf[Int]
  }

  override def setOutboundPermitted(value: scala.collection.mutable.Buffer[PermittedOptions]) = {
    asJava.setOutboundPermitted(value.map(_.asJava).asJava)
    this
  }

  override def addOutboundPermitted(value: PermittedOptions) = {
    asJava.addOutboundPermitted(value.asJava)
    this
  }

  override def getOutboundPermitteds: scala.collection.mutable.Buffer[PermittedOptions] = {
    asJava.getOutboundPermitteds().asScala.map(x => PermittedOptions(x))
  }

  override def setPingTimeout(value: Long) = {
    asJava.setPingTimeout(value)
    this
  }

  override def getPingTimeout: Long = {
    asJava.getPingTimeout().asInstanceOf[Long]
  }

  override def setReplyTimeout(value: Long) = {
    asJava.setReplyTimeout(value)
    this
  }

  override def getReplyTimeout: Long = {
    asJava.getReplyTimeout().asInstanceOf[Long]
  }

}


object BridgeOptions {

  def apply() = {
    new BridgeOptions(new JBridgeOptions(emptyObj()))
  }

  def apply(t: JBridgeOptions) = {
    if (t != null) {
      new BridgeOptions(t)
    } else {
      new BridgeOptions(new JBridgeOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): BridgeOptions = {
    if (json != null) {
      new BridgeOptions(new JBridgeOptions(json))
    } else {
      new BridgeOptions(new JBridgeOptions(emptyObj()))
    }
  }
}

