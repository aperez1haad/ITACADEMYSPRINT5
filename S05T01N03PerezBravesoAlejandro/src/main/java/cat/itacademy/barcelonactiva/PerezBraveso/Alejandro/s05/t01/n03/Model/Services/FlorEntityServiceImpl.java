package cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Model.Services;

import cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Model.DTO.FlorEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
public class FlorEntityServiceImpl implements FlorEntityService {

    @Autowired
    private WebClient webClient;

    @Override
    public FlorEntityDTO save(FlorEntityDTO florEntityDTO) {
        try {
            return webClient
                    .post() // Tipo de consulta que le hacemos a la API de 9001.
                    .uri("/add") // URI que necesitamos para hacer la consulta.
                    .bodyValue(florEntityDTO) // Parametros que necesita la consulta
                    .retrieve() // envia solicitud y espera respuesta
                    .bodyToMono(FlorEntityDTO.class) //convierte la respuesta en el objeto florenity
                    .block(); //bloquea hasta que recibe respuesta
        } catch (WebClientResponseException wcre) {
            System.out.println(wcre.getResponseBodyAsString());
            throw new RuntimeException("Error al cargar la flor");
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            throw new RuntimeException("Error al cargar la flor");
        }
    }
    @Override
    public FlorEntityDTO update(FlorEntityDTO florEntityDTO) {
        try {
            return webClient
                    .put()
                    .uri("/flor/update/{id}")
                    .bodyValue(florEntityDTO)
                    .retrieve()
                    .bodyToMono(FlorEntityDTO.class)
                    .block();
        } catch (WebClientResponseException wcre) {
            System.out.println(wcre.getResponseBodyAsString());
            throw new RuntimeException("Error al cargar la flor");
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            throw new RuntimeException("Error al cargar la flor");
        }
    }
    @Override
    public String deleteById(int id) {
        try {
            return webClient
                    .delete()
                    .uri("/flor/delete/{id}", id)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException wcre) {
            System.out.println(wcre.getResponseBodyAsString());
            throw new RuntimeException("Error al cargar la flor");
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            throw new RuntimeException("Error al cargar la flor");
        }
    }
    @Override
    public FlorEntityDTO findById(int id) {
        try {
            return webClient
                    .get()
                    .uri("/flor/getOne/{id}", id)
                    .retrieve()
                    .bodyToMono(FlorEntityDTO.class)
                    .block();
        } catch (WebClientResponseException wcre) {
            System.out.println(wcre.getResponseBodyAsString());
            throw new RuntimeException("Error al cargar la flor");
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            throw new RuntimeException("Error al cargar la flor");
        }
    }
    @Override
    public List<FlorEntityDTO> findAll() {
        try {
            return webClient
                    .get()
                    .uri("/flor/getAll")
                    .retrieve()
                    .bodyToFlux(FlorEntityDTO.class)
                    .collectList()
                    .block();
        } catch (WebClientResponseException wcre) {
            System.out.println(wcre.getResponseBodyAsString());
            throw new RuntimeException("Error al cargar la flor");
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            throw new RuntimeException("Error al cargar la flor");
        }
    }





}
