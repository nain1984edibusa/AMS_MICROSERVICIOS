/*
 * package
 * pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.configuration;
 * 
 * import org.springframework.cloud.client.circuitbreaker.Customizer; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.cloud.circuitbreaker.resilience4j.
 * Resilience4JCircuitBreakerFactory;
 * 
 * @Configuration public class Resilience4JConfiguration {
 * 
 * @Bean public Customizer<Resilience4JCircuitBreakerFactory>
 * globalCustomConfiguration() {
 * 
 * // the circuitBreakerConfig and timeLimiterConfig objects
 * 
 * return factory -> factory.configureDefault(id -> new
 * Resilience4JConfigBuilder(id) .timeLimiterConfig(timeLimiterConfig)
 * .circuitBreakerConfig(circuitBreakerConfig) .build()); } }
 */