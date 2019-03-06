package com.ginkodrop.grpc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.TextView;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @Descripition
 * @Auther liubing
 * @CreateTime 2019/3/5
 * @Version
 * @Since
 */

public class JWTActivity extends AppCompatActivity {

    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jwt);
        name = findViewById(R.id.name);
        name.setText(JWTGenerate());
    }

    public String JWTGenerate() {
        Map<String, Object> map = new HashMap<>();
        map.put("claim1", "claim1value");
        map.put("claim2", "claim2value");
        String key = Base64.encodeToString("secret".getBytes(), 0);
        //Key key = MacProvider.generateKey(SignatureAlgorithm.HS256);
        Date exp = new Date(System.currentTimeMillis() + 1000*60 * 1000);//过期时间
        String compactJws = Jwts.builder().addClaims(map).setHeaderParam("typ", "JWT")
                .signWith(SignatureAlgorithm.HS256, key).setExpiration(exp).compact();
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);
            //OK, we can trust this JWT
        } catch (ExpiredJwtException e) {//The key is expiration
            e.printStackTrace();
        }
        return compactJws;
    }
}
