package local.example.hateoas.cotroller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.example.hateoas.model.SaludoDto;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @GetMapping("/a")
    public EntityModel<SaludoDto> holaServicioA(){
        SaludoDto message =  new SaludoDto("Hola desde el servicio A");
        Link linkToServiceB = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServiceController.class).holaServicioB()).withRel("servicioB");
        return EntityModel.of(message, linkToServiceB);
    }

    @GetMapping("/b")
    public SaludoDto holaServicioB() {
        return new SaludoDto("Hola desde el servicio B");
    }
}
