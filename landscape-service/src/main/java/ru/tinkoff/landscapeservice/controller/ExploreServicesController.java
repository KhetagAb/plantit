package ru.tinkoff.landscapeservice.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.landscapeservice.service.ExploreServicesService;

@RestController
@RequestMapping("/explore")
public class ExploreServicesController {

    private final ExploreServicesService exploreServicesService;

    public ExploreServicesController(ExploreServicesService exploreServicesService) {
        this.exploreServicesService = exploreServicesService;
    }

    @GetMapping("/all")
    @ResponseBody
    public String getAllServicesVersion() {
        return protoToJson(exploreServicesService.getAllServicesVersion());
    }

    private static String protoToJson(Message message) {
        try {
            return JsonFormat.printer().print(message);
        } catch (InvalidProtocolBufferException e) {
            // TODO: log error
            return "< invalid message >";
        }
    }
}
