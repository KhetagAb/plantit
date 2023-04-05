package ru.tinkoff.landscapeservice.service;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.landscapeservice.properties.ServicesProperties;
import ru.tinkoff.proto.StatusServiceGrpc;
import ru.tinkoff.proto.VersionResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExploreServicesService {

    private final ServicesProperties servicesProperties;

    @Autowired
    public ExploreServicesService(ServicesProperties servicesProperties) {
        this.servicesProperties = servicesProperties;

    }

    private List<StatusServiceGrpc.StatusServiceBlockingStub> getStatusServiceBlockingStubs(List<String> services) {
        return services.stream()
                .map(ManagedChannelBuilder::forTarget)
                .map(ManagedChannelBuilder::usePlaintext)
                .map(ManagedChannelBuilder::build)
                .map(StatusServiceGrpc::newBlockingStub)
                .collect(Collectors.toList());
    }

    public List<VersionResponse> exploreHandymanVersions() {
        return getStatusServiceBlockingStubs(servicesProperties.getHandyman()).stream()
                .map(stub -> stub.getVersion(Empty.newBuilder().build()))
                .collect(Collectors.toList());
    }

    public List<VersionResponse> exploreRancherVersions() {
        return getStatusServiceBlockingStubs(servicesProperties.getRancher()).stream()
                .map(stub -> stub.getVersion(Empty.newBuilder().build()))
                .collect(Collectors.toList());
    }
}
