package org.javaboy.alipay.commons;

public class AlipayConfig {

	public static String app_id = "2016093000629153";
	
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC+rUuZBPRjdCuvUWdHG2gNMulWk1k5vCzHpnleootWDJ7sYLm4gmSKa/13Sss/i5Ea7M2tcXT8CZadIBifmmv6P7ar51QZMAj81bdqghw50F8UO9vHgkNK3q0ES0KCYdt+RU9lGLEIOB0VMm6ZJ+jeV36xwkSNChx8lmIUID+LsaLzy1fgKy0jtO1fvwe9atE6Pu1Q+2n1qDFPlBTCMOz79vEU8Qc0gVhLkbcYaqgylNP+dXQ8zJDw9Cy3ZcNHOasmiRuKubiCTGtRp859wF3RkK9yNxzQJO7ZAD5350bPfUrCtievPTEjN1k7WzL+kKug7uKwxpafF3uLSJm0hN2ZAgMBAAECggEAAjYQQl4EV4LpXsca44A13LFSc2aSClFcU5Rio+5On1jWHvegL7uTXueRsOh1Iu+DZ0SHvhMqwCF8VaYhovgveF90xtmP6Bref9AaqGmJ2kHIWHu5OL8R+LRMXVhiFRD9cqFrIkj/BJFiBPTow23rDWkGVxlhoiET43369TDKi9wmWvbCpkOhWTzUANT3LBS9G7+JNwzyORv2MYqg9V3HSbxHB5UB2razEZWRA5V6KMRIavI48ie3yfHG1cS3vscJmLbvksExZKwLQsWo9CWswYrOV4fU0NoVDiHYkIQtI6yXuwGAng7mhaOjTUWWPBb/FZETZHHCGX8jdaj+PVL2YQKBgQDwvVinPrdxZbd0dA3TBzKkbqpqIyzKdjpuilz/Zj0v6P7AXRxx80Cxis24bya6fBItwNV+sa7IXK08oWUhgwvDYaKjOuq0AwXRey/Zw+VJxbO5oy2N8RwmUNiOmSt6rxUme14WlCg+dX9ovaMKJfvHhRPrbpH+wJLh2ADo5gnarwKBgQDKw4u/G0txWDRL5fn2YV2AKwa22uPAfVhwExXnjOIAmzM3gJNs7Yd2JvOf9Tno6jwv7paQXRULYz6XUBcG/S3HhAwZbTFTXRuB++J9jIHZBp8FMKnHOwbLJ4O/PiWuiOsJd28ZVodHYYnP2QqD5vzqp+2Bhoie22f7yghl67e+NwKBgQDi3n2qdtcnfWUK0MeqZLEb9tKQXX+7ePmN7MTBR1dITDmvjM/erw/7gMRoGA+WVJBJH93SnJ4LYhM7/RkyIK44PU2oqEBAzkxwYrfwb8Un5bF+s0Gd72fI0A2VLNGlt1OmRUKg4pSeb9pXGceJK8x/9XCVQUlCm7aQMSCCWy9ULwKBgDP693txouCWzSlb9r3L7i1qWllMOjDhsWdh7S6kNlgTcYjcBG9bYWvPxosOUd89FVrwXlb6FegKdERUOuMGytKoLnXiQU/uwZuMGF85QxyBDwlElXHG1xIDukmvw/c/kImnvaqQPTP2dF79dC2mbNY3YLLg62tWMg0hmQ+P41X3AoGBAK7Xz8EUruQ0qMvvEJJuoFJCNvb6HtUv7ItC69plrd05KcAcYy2klxLfUPhJfpLEdqyhpuNm++9SRuKS6K8iF8hdm9An9hVgkOQ17WsDN9HThZjgI6fdPtNVC5sYorZ81LFfdHzgtu48fu5cv/L1dhVlM9de8m1k7s0CZIO1vBHV";

	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvq1LmQT0Y3Qrr1FnRxtoDTLpVpNZObwsx6Z5XqKLVgye7GC5uIJkimv9d0rLP4uRGuzNrXF0/AmWnSAYn5pr+j+2q+dUGTAI/NW3aoIcOdBfFDvbx4JDSt6tBEtCgmHbfkVPZRixCDgdFTJumSfo3ld+scJEjQocfJZiFCA/i7Gi88tX4CstI7TtX78HvWrROj7tUPtp9agxT5QUwjDs+/bxFPEHNIFYS5G3GGqoMpTT/nV0PMyQ8PQst2XDRzmrJokbirm4gkxrUafOfcBd0ZCvcjcc0CTu2QA+d+dGz31KwrYnrz0xIzdZO1sy/pCroO7isMaWnxd7i0iZtITdmQIDAQAB";
	
	public static String notify_url = "http://localhost:8080/alipay/alipayNotifyNotice";
	
	public static String return_url = "http://localhost:8080/alipay/alipayReturnNotice";
	
	public static String sign_type = "RSA2";
	
	public static String charset = "utf-8";
	
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}