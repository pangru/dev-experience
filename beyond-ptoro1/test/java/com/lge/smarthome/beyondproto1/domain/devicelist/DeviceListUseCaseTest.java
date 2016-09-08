package com.lge.smarthome.beyondproto1.domain.devicelist;

import com.lge.smarthome.beyondproto1.domain.PostExecutionThread;
import com.lge.smarthome.beyondproto1.domain.Session;
import com.lge.smarthome.beyondproto1.domain.ThreadExecutor;
import com.lge.smarthome.beyondproto1.domain.User;
import com.lge.smarthome.beyondproto1.domain.data.DeviceRepository;
import com.lge.smarthome.beyondproto1.domain.data.SessionRepository;
import com.lge.smarthome.beyondproto1.domain.data.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class DeviceListUseCaseTest {
    private DeviceListUseCase usecase;

    @Mock ThreadExecutor mockThreadExecutor;
    @Mock PostExecutionThread mockPostExecutionThread;
    @Mock SessionRepository mockSessionRepository;
    @Mock UserRepository mockUserRepository;
    @Mock DeviceRepository mockDeviceRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        usecase = new DeviceListUseCase(mockThreadExecutor, mockPostExecutionThread, mockSessionRepository, mockUserRepository, mockDeviceRepository);
    }

    @Test
    public void testBuildUseCaseObservable() throws Exception {
        User fakeUser = new User("id", "sessionId");
        Session fakeSession = new Session("sessionId", "sessionKey");
        given(mockUserRepository.get()).willReturn(Observable.just(fakeUser));
        given(mockSessionRepository.get(fakeUser.getSessionId())).willReturn(Observable.just(fakeSession));

        usecase.buildUseCaseObservable();

        verify(mockUserRepository).get();
//        verify(mockSessionRepository).get(fakeUser.getSessionId());
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}