package org.skye.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.skye.Dao.MessageDao;
import org.skye.bean.Message;
import org.skye.dto.MessageDto;
import org.skye.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDao messageDao;

	public List<MessageDto> getList() {
		List<MessageDto> result = new ArrayList<MessageDto>();
		List<Message> messageList = messageDao.getList();
		for(Message message : messageList) {
			MessageDto messageDtoTemp = new MessageDto();
			BeanUtils.copyProperties(message, messageDtoTemp);
			result.add(messageDtoTemp);
		}
		return result;
	}

}
