package ru.tinkoff.rancherservice.connectivity;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import ru.tinkoff.proto.ReadinessResponse;
import ru.tinkoff.proto.StatusServiceGrpc;
import ru.tinkoff.proto.VersionResponse;
import ru.tinkoff.rancherservice.service.SystemService;

@GrpcService
public class StatusService extends StatusServiceGrpc.StatusServiceImplBase {


    private final BuildProperties buildProperties;

    private final SystemService systemService;

    @Autowired
    public StatusService(BuildProperties buildProperties, SystemService systemService) {
        this.buildProperties = buildProperties;
        this.systemService = systemService;
    }

    @Override
    public void getVersion(Empty request, StreamObserver<VersionResponse> responseObserver) {
        var versionResponse = VersionResponse.newBuilder()
                .setVersion(buildProperties.getVersion())
                .setArtifact(buildProperties.getArtifact())
                .setGroup(buildProperties.getGroup())
                .setName(buildProperties.getName())
                .build();

        responseObserver.onNext(versionResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getReadiness(Empty request, StreamObserver<ReadinessResponse> responseObserver) {
        var readinessResponse = ReadinessResponse.newBuilder()
                .setStatus(systemService.getReadiness().toString())
                .build();

        responseObserver.onNext(readinessResponse);
        responseObserver.onCompleted();
    }
}
