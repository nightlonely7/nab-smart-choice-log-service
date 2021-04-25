package au.com.nab.smartchoice.logservice.service;

import au.com.nab.smartchoice.logservice.dto.model.HttpLogModel;

public interface HttpLogService {
    HttpLogModel save(HttpLogModel httpLogModel);
}
