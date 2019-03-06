package io.grpc.examples.login;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * 定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: LoginService.proto")
public final class LoginServerGrpc {

  private LoginServerGrpc() {}

  public static final String SERVICE_NAME = "login.LoginServer";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grpc.examples.login.LoginRequest,
      io.grpc.examples.login.LoginReply> METHOD_LOGIN = getLoginMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.login.LoginRequest,
      io.grpc.examples.login.LoginReply> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.examples.login.LoginRequest,
      io.grpc.examples.login.LoginReply> getLoginMethod() {
    return getLoginMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.examples.login.LoginRequest,
      io.grpc.examples.login.LoginReply> getLoginMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.examples.login.LoginRequest, io.grpc.examples.login.LoginReply> getLoginMethod;
    if ((getLoginMethod = LoginServerGrpc.getLoginMethod) == null) {
      synchronized (LoginServerGrpc.class) {
        if ((getLoginMethod = LoginServerGrpc.getLoginMethod) == null) {
          LoginServerGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.login.LoginRequest, io.grpc.examples.login.LoginReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "login.LoginServer", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  io.grpc.examples.login.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  io.grpc.examples.login.LoginReply.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoginServerStub newStub(io.grpc.Channel channel) {
    return new LoginServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoginServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LoginServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoginServerFutureStub(channel);
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static abstract class LoginServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(io.grpc.examples.login.LoginRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.login.LoginReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.login.LoginRequest,
                io.grpc.examples.login.LoginReply>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class LoginServerStub extends io.grpc.stub.AbstractStub<LoginServerStub> {
    private LoginServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServerStub(channel, callOptions);
    }

    /**
     */
    public void login(io.grpc.examples.login.LoginRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.login.LoginReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class LoginServerBlockingStub extends io.grpc.stub.AbstractStub<LoginServerBlockingStub> {
    private LoginServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.login.LoginReply login(io.grpc.examples.login.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class LoginServerFutureStub extends io.grpc.stub.AbstractStub<LoginServerFutureStub> {
    private LoginServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.login.LoginReply> login(
        io.grpc.examples.login.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoginServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoginServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((io.grpc.examples.login.LoginRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.login.LoginReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LoginServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getLoginMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
