package com.software.grey.controllers;

import com.software.grey.models.dtos.PostDTO;
import com.software.grey.services.implementations.PostService;
import com.software.grey.utils.EndPoints;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(EndPoints.POST)
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @Operation(
            summary = "to create a new post",
            description = "Use this end point to enable the user to create new post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The post is created successfully"),
            @ApiResponse(responseCode = "400", description = "The post is not save due to invalid request body")
    })
    @PostMapping(EndPoints.ADD_POST)
    public ResponseEntity<UUID> addPost(@Valid @RequestBody PostDTO postDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.add(postDTO));
    }
}
