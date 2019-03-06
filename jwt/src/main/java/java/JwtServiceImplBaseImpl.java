package java;

import io.grpc.examples.jwt.JwtReply;
import io.grpc.examples.jwt.JwtRequest;
import io.grpc.examples.jwt.JwtServerGrpc;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

import java.util.Base64;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JwtServiceImplBaseImpl extends JwtServerGrpc.JwtServerImplBase{
    private Logger logger = Logger.getLogger(JwtServiceImplBaseImpl.class.getName());
    @Override
    public void jwt(JwtRequest request, StreamObserver<JwtReply> responseObserver) {
        String token = request.getToken();
        logger.log(Level.INFO,"requst is coming. args1=" + token);
        JWTParse(token);
        JwtReply jwt = JwtReply.newBuilder().setMessage("JWT成功").build();
        responseObserver.onNext(jwt);
        responseObserver.onCompleted();

    }

    public void JWTParse(String jwt) {
        //编码
        String key = Base64.getEncoder().encodeToString("secret".getBytes());
        //Key key = MacProvider.generateKey(SignatureAlgorithm.HS256);
        //在解析的时候一定要传key进去，否则无法通过key的认证
        Jwt parse = Jwts.parser().setSigningKey(key).parse(jwt);
        Header header = parse.getHeader();
        Map<String, Object> map = (Map<String, Object>) parse.getBody();
        String param = (String) map.get("param");
    }
}
