package travelAgency.agency.application;
import org.modelmapper.ModelMapper;

public interface ModelMapperServices {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
