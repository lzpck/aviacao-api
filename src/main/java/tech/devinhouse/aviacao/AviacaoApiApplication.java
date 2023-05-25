package tech.devinhouse.aviacao;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tech.devinhouse.aviacao.model.Classificacao;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.service.PassageiroService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AviacaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AviacaoApiApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages.properties");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Bean
	CommandLineRunner runnerPassageiro (PassageiroService passageiroService) {
		return args -> {
			if (passageiroService.consultar().isEmpty()) {
				List<Passageiro> passageiros = Arrays.asList(
						new Passageiro(11111111111L, "James Tiberius Kirk", LocalDate.parse("1933-10-01"), Classificacao.VIP, 100, null),
						new Passageiro(22222222222L, "Spock", LocalDate.parse("1930-09-05"), Classificacao.OURO, 100, null),
						new Passageiro(33333333333L, "Leonard McCoy", LocalDate.parse("1927-04-02"), Classificacao.PRATA, 100, null),
						new Passageiro(44444444444L, "Montgomery Scott", LocalDate.parse("1922-08-08"), Classificacao.OURO, 100, null),
						new Passageiro(55555555555L, "Nyota Uhura", LocalDate.parse("1934-11-20"), Classificacao.OURO, 100, null),
						new Passageiro(66666666666L, "Hikaru Kato Sulu", LocalDate.parse("1931-10-21"), Classificacao.BRONZE, 100, null),
						new Passageiro(77777777777L, "Jean-Luc Picard", LocalDate.parse("1960-07-20"), Classificacao.VIP, 100, null),
						new Passageiro(88888888888L, "Wesley Crusher", LocalDate.parse("2010-10-01"), Classificacao.ASSOCIADO, 100, null)
				);

				for (Passageiro passageiro : passageiros) {
					passageiroService.salvar(passageiro);
				}
			}
		};
	}

}
