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

package io.vertx.scala.core.net

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.lang.scala.HandlerOps._

/**
  * Represents a socket-like interface to a TCP connection on either the
  * client or the server side.
  * 
  * Instances of this class are created on the client side by an [[io.vertx.scala.core.net.NetClient]]
  * when a connection to a server is made, or on the server side by a [[io.vertx.scala.core.net.NetServer]]
  * when a server accepts a connection.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */

class NetSocket(private val _asJava: Object) extends ReadStream[io.vertx.core.buffer.Buffer]with WriteStream[io.vertx.core.buffer.Buffer] {
  def asJava = _asJava
  private var cached_0: Option[SocketAddress] = None
  private var cached_1: Option[SocketAddress] = None


  /**
   * @return the remote address for this connection, possibly `null` (e.g a server bound on a domain socket)
   */
  def remoteAddress(): SocketAddress = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JNetSocket].remoteAddress()
      cached_0 = Some(SocketAddress(tmp))
    }
    cached_0.get
  }

  /**
   * @return the local address for this connection, possibly `null` (e.g a server bound on a domain socket)
   */
  def localAddress(): SocketAddress = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JNetSocket].localAddress()
      cached_1 = Some(SocketAddress(tmp))
    }
    cached_1.get
  }



  override 
  def exceptionHandler(handler: Handler[Throwable]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def handler(handler: Handler[io.vertx.core.buffer.Buffer]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].handler((if (handler == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {handler.handle(x)}}))
    this
  }


  override 
  def pause(): NetSocket = {
    asJava.asInstanceOf[JNetSocket].pause()
    this
  }


  override 
  def resume(): NetSocket = {
    asJava.asInstanceOf[JNetSocket].resume()
    this
  }


  override 
  def fetch(amount: Long): NetSocket = {
    asJava.asInstanceOf[JNetSocket].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * 
   * 
   * This handler might be called after the close handler when the socket is paused and there are still
   * buffers to deliver.
   */
  override 
  def endHandler(endHandler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }


  override 
  def write(data: io.vertx.core.buffer.Buffer): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(data)
    this
  }


  override 
  def setWriteQueueMaxSize(maxSize: Int): NetSocket = {
    asJava.asInstanceOf[JNetSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].drainHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Same as [[io.vertx.scala.core.net.NetSocket#write]] but with an `handler` called when the operation completes
   */
  
  def write(str: String, handler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Write a String to the connection, encoded in UTF-8.   * @param str the string to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def write(str: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Same as [[io.vertx.scala.core.net.NetSocket#write]] but with an `handler` called when the operation completes
   */
  
  def write(str: String, enc: String, handler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Write a String to the connection, encoded using the encoding `enc`.   * @param str the string to write
   * @param enc the encoding to use
   * @return a reference to this, so the API can be used fluently
   */
  
  def write(str: String, enc: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Like  but with an `handler` called when the message has been written
   * or failed to be written.
   */
  override 
  def write(message: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(message, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
   * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.   * @param filename file name of the file to send
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
   * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.   * @param filename file name of the file to send
   * @param offset offset
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
   * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.   * @param filename file name of the file to send
   * @param offset offset
   * @param length length
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long, length: Long): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
   * a failure has occurred   * @param filename file name of the file to send
   * @param resultHandler handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, resultHandler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
   * a failure has occurred   * @param filename file name of the file to send
   * @param offset offset
   * @param resultHandler handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long, resultHandler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
   * a failure has occurred   * @param filename file name of the file to send
   * @param offset offset
   * @param length length
   * @param resultHandler handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long, length: Long, resultHandler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set a handler that will be called when the NetSocket is closed   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def closeHandler(handler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].closeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Upgrade channel to use SSL/TLS. Be aware that for this to work SSL must be configured.   * @param handler the handler will be notified when it's upgraded
   * @return a reference to this, so the API can be used fluently
   */
  
  def upgradeToSsl(handler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].upgradeToSsl((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Upgrade channel to use SSL/TLS. Be aware that for this to work SSL must be configured.   * @param serverName the server name
   * @param handler the handler will be notified when it's upgraded
   * @return a reference to this, so the API can be used fluently
   */
  
  def upgradeToSsl(serverName: String, handler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].upgradeToSsl(serverName.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }


  /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  override def pipe(): Pipe[io.vertx.core.buffer.Buffer] = {
    Pipe[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JNetSocket].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer]): Unit = {
    asJava.asInstanceOf[JNetSocket].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]])
  }

  /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JNetSocket].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Same as [[io.vertx.scala.core.net.NetSocket#end]] but writes some data to the stream before ending.   * @param data the data to write
   */
  override def end(data: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JNetSocket].end(data)
  }

  /**
   * Same as  but with an `handler` called when the operation completes
   */
  override def end(data: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JNetSocket].end(data, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  /**
   * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.net.NetSocket#setWriteQueueMaxSize]]   * @return true if write queue is full
   */
  override def writeQueueFull (): Boolean = {
    asJava.asInstanceOf[JNetSocket].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
   * When a `NetSocket` is created it automatically registers an event handler with the event bus, the ID of that
   * handler is given by `writeHandlerID`.
   * 
   * Given this ID, a different event loop can send a buffer to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other connections which are owned by different event loops.   * @return the write handler ID
   */
  def writeHandlerID (): String = {
    asJava.asInstanceOf[JNetSocket].writeHandlerID().asInstanceOf[String]
  }

  /**
   * Calls [[io.vertx.scala.core.net.NetSocket#close]]
   */
  override def end (): Unit = {
    asJava.asInstanceOf[JNetSocket].end()
  }

  /**
   * Calls [[io.vertx.scala.core.net.NetSocket#end]]
   */
  override def end (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JNetSocket].end((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Close the NetSocket
   */
  def close (): Unit = {
    asJava.asInstanceOf[JNetSocket].close()
  }

  /**
   * Close the NetSocket and notify the `handler` when the operation completes.
   */
  def close (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JNetSocket].close((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * @return true if this io.vertx.scala.core.net.NetSocket is encrypted via SSL/TLS.
   */
  def isSsl (): Boolean = {
    asJava.asInstanceOf[JNetSocket].isSsl().asInstanceOf[Boolean]
  }

  /**
   * Returns the SNI server name presented during the SSL handshake by the client.   * @return the indicated server name
   */
  def indicatedServerName (): String = {
    asJava.asInstanceOf[JNetSocket].indicatedServerName().asInstanceOf[String]
  }


 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def pipeToFuture (dst: WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].end(data, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def writeFuture (str: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def writeFuture (str: String, enc: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def writeFuture (message: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].write(message, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFileFuture (filename: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFileFuture (filename: String, offset: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFileFuture (filename: String, offset: Long, length: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].end(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object NetSocket {
  def apply(asJava: JNetSocket) = new NetSocket(asJava)

}
