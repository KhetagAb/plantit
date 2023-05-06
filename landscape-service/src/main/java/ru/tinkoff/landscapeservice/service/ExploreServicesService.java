package ru.tinkoff.landscapeservice.service;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.landscapeservice.properties.ServicesProperties;
import ru.tinkoff.proto.StatusServiceGrpc;
import ru.tinkoff.proto.VersionResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExploreServicesService {

    private final ServicesProperties servicesProperties;

    @Autowired
    public ExploreServicesService(ServicesProperties servicesProperties) {
        this.servicesProperties = servicesProperties;
    }

    private List<VersionResponse> getHostsVersions(List<String> hosts) {
        Empty empty = Empty.newBuilder()
                .build();

        List<VersionResponse> list = new ArrayList<>();
        for (String host : hosts) {
            try {
                ManagedChannel managedChannel = ManagedChannelBuilder.forTarget(host)
                        .usePlaintext()
                        .build();
                VersionResponse version = StatusServiceGrpc.newBlockingStub(managedChannel)
                        .getVersion(empty);
                list.add(version);
            } catch (StatusRuntimeException e) {
                System.err.println("Exception during gRPC call to services: " + e.getMessage());
                // TODO: log error
            }
        }
        return list;
    }

    /**
     * Explore handyman services from services properties with gRPC call
     * @return list of versions as proto messages
     */
    public List<VersionResponse> exploreHandymanVersions() {
        return getHostsVersions(servicesProperties.getHandyman());
    }

    /**
     * Explore rancher services from services properties with gRPC call
     * @return list of versions as proto messages
     */
    public List<VersionResponse> exploreRancherVersions() {
        return getHostsVersions(servicesProperties.getRancher());
    }
}