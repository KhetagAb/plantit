package ru.tinkoff.handymanservice.server.connectivity;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import ru.tinkoff.handymanservice.server.service.SystemService;
import ru.tinkoff.proto.ReadinessResponse;
import ru.tinkoff.proto.StatusServiceGrpc;
import ru.tinkoff.proto.VersionResponse;

@GrpcService
public class StatusService extends StatusServiceGrpc.StatusServiceImplBase {

    private final static String OK = HttpStatus.OK.toString();
    private final static String TOO_EARLY = HttpStatus.TOO_EARLY.toString();

    @Autowired
    private BuildProperties buildProperties;

    @Autowired
    private SystemService systemService;

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
                .setStatus(systemService.getReadiness() ? OK : TOO_EARLY)
                .build();

        responseObserver.onNext(readinessResponse);
        responseObserver.onCompleted();
    }
}
