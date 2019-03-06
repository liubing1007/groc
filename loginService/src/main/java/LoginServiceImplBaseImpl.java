
import io.grpc.examples.login.LoginReply;
import io.grpc.examples.login.LoginRequest;
import io.grpc.examples.login.LoginServerGrpc;
import io.grpc.stub.StreamObserver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServiceImplBaseImpl extends LoginServerGrpc.LoginServerImplBase{
    private Logger logger = Logger.getLogger(LoginServiceImplBaseImpl.class.getName());
    @Override
    public void login(LoginRequest request, StreamObserver<LoginReply> responseObserver) {
        logger.log(Level.INFO,"requst is coming. args1=" + request.getUserName());
        logger.log(Level.INFO,"requst is coming. args2=" + request.getPwd());
        if(request.getUserName().equals("admin") && request.getPwd().equals("admin")) {
            LoginReply login = LoginReply.newBuilder().setCode(0).setMessage("ok").build();
            responseObserver.onNext(login);
        }else{
            LoginReply login = LoginReply.newBuilder().setCode(1).setMessage("登录失败").build();
            responseObserver.onNext(login);
        }
        responseObserver.onCompleted();

    }
}
