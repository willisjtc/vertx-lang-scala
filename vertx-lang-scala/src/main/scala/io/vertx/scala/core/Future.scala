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

package io.vertx.scala.core

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Promise => JPromise}
import scala.reflect.runtime.universe._
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents the result of an action that may, or may not, have occurred yet.
  * 
  */

class Future[T: TypeTag](private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[Handler[AsyncResult[T]]] = None


  /**
   * @return an handler completing this future
   */
  def completer(): Handler[AsyncResult[T]] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JFuture[Object]].completer()
      cached_0 = Some(if (tmp == null) null else {x: AsyncResult[T] => tmp.handle(AsyncResultWrapper[T, Object](x, a => toJava[T](a)))})
    }
    cached_0.get
  }


  /**
   * Like [[io.vertx.scala.core.Future#onComplete]].   */
  
  def setHandler(handler: Handler[AsyncResult[T]]): Future[T] = {
    asJava.asInstanceOf[JFuture[Object]].setHandler((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Object]]{def handle(x: AsyncResult[Object]) {handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}}))
    this
  }

  /**
   * Add a handler to be notified of the result.
   * <br/>   * @param handler the handler that will be called with the result
   * @return a reference to this, so it can be used fluently
   */
  
  def onComplete(handler: Handler[AsyncResult[T]]): Future[T] = {
    asJava.asInstanceOf[JFuture[Object]].onComplete((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Object]]{def handle(x: AsyncResult[Object]) {handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}}))
    this
  }

  /**
   * Add a handler to be notified of the succeeded result.
   * <br/>   * @param handler the handler that will be called with the succeeded result
   * @return a reference to this, so it can be used fluently
   */
  
  def onSuccess(handler: Handler[T]): Future[T] = {
    asJava.asInstanceOf[JFuture[Object]].onSuccess((if (handler == null) null else new io.vertx.core.Handler[Object]{def handle(x: Object) {handler.handle(toScala[T](x))}}))
    this
  }

  /**
   * Add a handler to be notified of the failed result.
   * <br/>   * @param handler the handler that will be called with the failed result
   * @return a reference to this, so it can be used fluently
   */
  
  def onFailure(handler: Handler[Throwable]): Future[T] = {
    asJava.asInstanceOf[JFuture[Object]].onFailure((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  /**
   * Alias for [[io.vertx.scala.core.Future#compose]].
   */
  def flatMap[U: TypeTag](mapper: T => Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].flatMap[Object]({x: Object => mapper(toScala[T](x)).asJava.asInstanceOf[JFuture[Object]]}))
  }

  /**
   * Compose this future with a `mapper` function.
   * 
   * When this future (the one on which `compose` is called) succeeds, the `mapper` will be called with
   * the completed value and this mapper returns another future object. This returned future completion will complete
   * the future returned by this method call.
   * 
   * If the `mapper` throws an exception, the returned future will be failed with this exception.
   * 
   * When this future fails, the failure will be propagated to the returned future and the `mapper`
   * will not be called.   * @param mapper the mapper function
   * @return the composed future
   */
  def compose[U: TypeTag](mapper: T => Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].compose[Object]({x: Object => mapper(toScala[T](x)).asJava.asInstanceOf[JFuture[Object]]}))
  }

  /**
   * Compose this future with a `successMapper` and `failureMapper` functions.
   * 
   * When this future (the one on which `compose` is called) succeeds, the `successMapper` will be called with
   * the completed value and this mapper returns another future object. This returned future completion will complete
   * the future returned by this method call.
   * 
   * When this future (the one on which `compose` is called) fails, the `failureMapper` will be called with
   * the failure and this mapper returns another future object. This returned future completion will complete
   * the future returned by this method call.
   * 
   * If any mapper function throws an exception, the returned future will be failed with this exception.   * @param successMapper the function mapping the success
   * @param failureMapper the function mapping the failure
   * @return the composed future
   */
  def compose[U: TypeTag](successMapper: T => Future[U], failureMapper: Throwable => Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].compose[Object]({x: Object => successMapper(toScala[T](x)).asJava.asInstanceOf[JFuture[Object]]}, {x: Throwable => failureMapper(x).asJava.asInstanceOf[JFuture[Object]]}))
  }

  /**
   * Apply a `mapper` function on this future.
   * 
   * When this future succeeds, the `mapper` will be called with the completed value and this mapper
   * returns a value. This value will complete the future returned by this method call.
   * 
   * If the `mapper` throws an exception, the returned future will be failed with this exception.
   * 
   * When this future fails, the failure will be propagated to the returned future and the `mapper`
   * will not be called.   * @param mapper the mapper function
   * @return the mapped future
   */
  def map[U: TypeTag](mapper: T => U): Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].map[Object]({x: Object => toJava[U](mapper(toScala[T](x)))}))
  }

  /**
   * Map the result of a future to a specific `value`.
   * 
   * When this future succeeds, this `value` will complete the future returned by this method call.
   * 
   * When this future fails, the failure will be propagated to the returned future.   * @param value the value that eventually completes the mapped future
   * @return the mapped future
   */
  def map[V: TypeTag](value: V): Future[V] = {
    Future[V](asJava.asInstanceOf[JFuture[Object]].map[Object](toJava[V](value)))
  }

  /**
   * Map the result of a future to `null`.
   * 
   * This is a conveniency for `future.map((T) null)` or `future.map((Void) null)`.
   * 
   * When this future succeeds, `null` will complete the future returned by this method call.
   * 
   * When this future fails, the failure will be propagated to the returned future.   * @return the mapped future
   */
  def mapEmpty[V: TypeTag](): Future[V] = {
    Future[V](asJava.asInstanceOf[JFuture[Object]].mapEmpty[Object]())
  }

  /**
   * Handles a failure of this Future by returning the result of another Future.
   * If the mapper fails, then the returned future will be failed with this failure.   * @param mapper A function which takes the exception of a failure and returns a new future.
   * @return A recovered future
   */
  def recover(mapper: Throwable => Future[T]): Future[T] = {
    Future[T](asJava.asInstanceOf[JFuture[Object]].recover({x: Throwable => mapper(x).asJava.asInstanceOf[JFuture[Object]]}))
  }

  /**
   * Apply a `mapper` function on this future.
   * 
   * When this future fails, the `mapper` will be called with the completed value and this mapper
   * returns a value. This value will complete the future returned by this method call.
   * 
   * If the `mapper` throws an exception, the returned future will be failed with this exception.
   * 
   * When this future succeeds, the result will be propagated to the returned future and the `mapper`
   * will not be called.   * @param mapper the mapper function
   * @return the mapped future
   */
  def otherwise(mapper: Throwable => T): Future[T] = {
    Future[T](asJava.asInstanceOf[JFuture[Object]].otherwise({x: Throwable => toJava[T](mapper(x))}))
  }

  /**
   * Map the failure of a future to a specific `value`.
   * 
   * When this future fails, this `value` will complete the future returned by this method call.
   * 
   * When this future succeeds, the result will be propagated to the returned future.   * @param value the value that eventually completes the mapped future
   * @return the mapped future
   */
  def otherwise(value: T): Future[T] = {
    Future[T](asJava.asInstanceOf[JFuture[Object]].otherwise(toJava[T](value)))
  }

  /**
   * Map the failure of a future to `null`.
   * 
   * This is a convenience for `future.otherwise((T) null)`.
   * 
   * When this future fails, the `null` value will complete the future returned by this method call.
   * 
   * When this future succeeds, the result will be propagated to the returned future.   * @return the mapped future
   */
  def otherwiseEmpty(): Future[T] = {
    Future[T](asJava.asInstanceOf[JFuture[Object]].otherwiseEmpty())
  }


  /**
   * Has the future completed?
   * 
   * It's completed if it's either succeeded or failed.   * @return true if completed, false if not
   */
  def isComplete (): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].isComplete().asInstanceOf[Boolean]
  }

  /**
   * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.   * @param result the result
   */
  def complete (result: T): Unit = {
    asJava.asInstanceOf[JFuture[Object]].complete(toJava[T](result))
  }

  /**
   * Set a null result. Any handler will be called, if there is one, and the future will be marked as completed.   */
  def complete (): Unit = {
    asJava.asInstanceOf[JFuture[Object]].complete()
  }

  /**
   * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.   * @param cause the failure cause
   */
  def fail (cause: Throwable): Unit = {
    asJava.asInstanceOf[JFuture[Object]].fail(cause)
  }

  /**
   * Try to set the failure. When it happens, any handler will be called, if there is one, and the future will be marked as completed.   * @param failureMessage the failure message
   */
  def fail (failureMessage: String): Unit = {
    asJava.asInstanceOf[JFuture[Object]].fail(failureMessage.asInstanceOf[java.lang.String])
  }

  /**
   * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.   * @param result the result
   * @return false when the future is already completed
   */
  def tryComplete (result: T): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].tryComplete(toJava[T](result)).asInstanceOf[Boolean]
  }

  /**
   * Try to set the result. When it happens, any handler will be called, if there is one, and the future will be marked as completed.   * @return false when the future is already completed
   */
  def tryComplete (): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].tryComplete().asInstanceOf[Boolean]
  }

  /**
   * Try to set the failure. When it happens, any handler will be called, if there is one, and the future will be marked as completed.   * @param cause the failure cause
   * @return false when the future is already completed
   */
  def tryFail (cause: Throwable): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].tryFail(cause).asInstanceOf[Boolean]
  }

  /**
   * Try to set the failure. When it happens, any handler will be called, if there is one, and the future will be marked as completed.   * @param failureMessage the failure message
   * @return false when the future is already completed
   */
  def tryFail (failureMessage: String): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].tryFail(failureMessage.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  /**
   * The result of the operation. This will be null if the operation failed.   * @return the result or null if the operation failed.
   */
  def result (): T = {
    toScala[T](asJava.asInstanceOf[JFuture[Object]].result())
  }

  /**
   * A Throwable describing failure. This will be null if the operation succeeded.   * @return the cause or null if the operation succeeded.
   */
  def cause (): Throwable = {
    asJava.asInstanceOf[JFuture[Object]].cause()
  }

  /**
   * Did it succeed?   * @return true if it succeded or false otherwise
   */
  def succeeded (): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].succeeded().asInstanceOf[Boolean]
  }

  /**
   * Did it fail?   * @return true if it failed or false otherwise
   */
  def failed (): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].failed().asInstanceOf[Boolean]
  }


}

object Future {
  def apply[T: TypeTag](asJava: JFuture[_]) = new Future[T](asJava)

  /**
   * Create a future that hasn't completed yet and that is passed to the `handler` before it is returned.   * @param handler the handler
   * @return the future.
   */
  def future[T: TypeTag](handler: Handler[Promise[T]]): Future[T] = {
    Future[T](JFuture.future[Object]((if (handler == null) null else new io.vertx.core.Handler[JPromise[Object]]{def handle(x: JPromise[Object]) {handler.handle(Promise[T](x))}})))//2 future
  }

  /**
   * Create a future that hasn't completed yet   * @return the future
   */
  def future[T: TypeTag](): Future[T] = {
    Future[T](JFuture.future[Object]())//2 future
  }

  /**
   * Create a succeeded future with a null result   * @return the future
   */
  def succeededFuture[T: TypeTag](): Future[T] = {
    Future[T](JFuture.succeededFuture[Object]())//2 succeededFuture
  }

  /**
   * Created a succeeded future with the specified result.   * @param result the result
   * @return the future
   */
  def succeededFuture[T: TypeTag](result: T): Future[T] = {
    Future[T](JFuture.succeededFuture[Object](toJava[T](result)))//2 succeededFuture
  }

  /**
   * Create a failed future with the specified failure cause.   * @param t the failure cause as a Throwable
   * @return the future
   */
  def failedFuture[T: TypeTag](t: Throwable): Future[T] = {
    Future[T](JFuture.failedFuture[Object](t))//2 failedFuture
  }

  /**
   * Create a failed future with the specified failure message.   * @param failureMessage the failure message
   * @return the future
   */
  def failedFuture[T: TypeTag](failureMessage: String): Future[T] = {
    Future[T](JFuture.failedFuture[Object](failureMessage.asInstanceOf[java.lang.String]))//2 failedFuture
  }

}
