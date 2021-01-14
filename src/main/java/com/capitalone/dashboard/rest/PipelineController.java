package com.capitalone.dashboard.rest;

import com.capitalone.dashboard.misc.HygieiaException;
import com.capitalone.dashboard.model.PipelineResponse;
import com.capitalone.dashboard.request.PipelineSearchRequest;
import com.capitalone.dashboard.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PipelineController {
    private final PipelineService pipelineService;

    @Autowired
    public PipelineController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @RequestMapping(value = "/pipeline", method = GET, produces = APPLICATION_JSON_VALUE)

    public Iterable searchPipelines(@RequestParam String collectorItemId, @RequestParam String beginDate, @RequestParam String endDate) throws HygieiaException {
        PipelineSearchRequest pipelineSearchRequest = new PipelineSearchRequest();
        pipelineSearchRequest.setBeginDate(Long.valueOf(beginDate));
        pipelineSearchRequest.setEndDate(Long.valueOf(endDate));
        List collectorItemIdList = new ArrayList<>();
        collectorItemIdList.add(new ObjectId(collectorItemId));
        pipelineSearchRequest.setCollectorItemId(collectorItemIdList);
        return pipelineService.search(pipelineSearchRequest);
    } 
}
