package com.melikesivrikaya.userservice.controller;

import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.model.enums.UserType;
import com.melikesivrikaya.userservice.repository.UserRepository;
import com.melikesivrikaya.userservice.service.UserCustomerService;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserCustomerController.class)
class UserCustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private UserCustomerController userCustomerController;
    @MockBean
    private UserCustomerService userCustomerService;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userCustomerController).build();
    }

    @Test
    void hi() throws Exception {
        mockMvc.perform(get("/api/v1/users/customer"))
                .andExpect(status().isOk())  // HTTP 200 durum kodu bekleniyor
                .andExpect(content().string("hi"));  // Yanıtın içeriği "hi" olmalı
    }

    @Test
    void getUser() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/v1/users/customer").contentType(MediaType.APPLICATION_JSON));

        Mockito.when(userCustomerService.getUser(1L)).thenReturn(prepeareUser());


        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("melikesivrikaya"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@gmail.com"));
    }

    private User prepeareUser() {
        return User.builder()
                .username("melikesivrikaya")
                .phone("test")
                .email("test@gmail.com")
                .build();
    }


}
