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

package io.vertx.scala.ext.mongo

import io.vertx.ext.mongo.{UpdateOptions => JUpdateOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options for configuring updates.
 */

class UpdateOptions(private val _asJava: JUpdateOptions) {
  def asJava = _asJava
  /**
   * Set whether multi is enabled
   */
  def setMulti(value: Boolean) = {
    asJava.setMulti(value)
    this
  }

  def isMulti: Boolean = {
    asJava.isMulti().asInstanceOf[Boolean]
  }

  /**
   * Set whether new document property is enabled. Valid only on findOneAnd* methods.
   */
  def setReturningNewDocument(value: Boolean) = {
    asJava.setReturningNewDocument(value)
    this
  }

  def isReturningNewDocument: Boolean = {
    asJava.isReturningNewDocument().asInstanceOf[Boolean]
  }

  /**
   * Set whether upsert is enabled
   */
  def setUpsert(value: Boolean) = {
    asJava.setUpsert(value)
    this
  }

  def isUpsert: Boolean = {
    asJava.isUpsert().asInstanceOf[Boolean]
  }

  /**
   * Set the write option
   */
  def setWriteOption(value: io.vertx.ext.mongo.WriteOption) = {
    asJava.setWriteOption(value)
    this
  }

  def getWriteOption: io.vertx.ext.mongo.WriteOption = {
    asJava.getWriteOption()
  }

}


object UpdateOptions {
  
  def apply() = {
    new UpdateOptions(new JUpdateOptions(emptyObj()))
  }
  
  def apply(t: JUpdateOptions) = {
    if (t != null) {
      new UpdateOptions(t)
    } else {
      new UpdateOptions(new JUpdateOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): UpdateOptions = {
    if (json != null) {
      new UpdateOptions(new JUpdateOptions(json))
    } else {
      new UpdateOptions(new JUpdateOptions(emptyObj()))
    }
  }
}
