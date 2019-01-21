package com.example.jeedemo.restclients;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class HmacHeaderInterceptor implements ClientRequestFilter {

	private static final String HMAC_HASH_ALGORITHM = "HmacSHA256";

	private static final String HASH_HEADER = "Content-Hash";

	private static final String HASH_KEY = "thisIsVerySecureKey!@#$%^&*()";

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		Jsonb jsonb = JsonbBuilder.create();
		String afterJson = jsonb.toJson(requestContext.getEntity());
		requestContext.setEntity(afterJson);
		requestContext.getHeaders().add(HASH_HEADER, hash(HASH_KEY, afterJson));
	}

	private String hash(String key, String data) {
		try {
			Mac sha256_HMAC = Mac.getInstance(HMAC_HASH_ALGORITHM);
			SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(UTF_8), HMAC_HASH_ALGORITHM);
			sha256_HMAC.init(secret_key);
			return toHexString(sha256_HMAC.doFinal(data.getBytes(UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			// No need to handle
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return "";
	}

	private String toHexString(byte[] bytes) {
		return new BigInteger(1, bytes).toString(16);
	}
}