package com.slackbot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slackbot.model.Attachment;
import com.slackbot.model.SlackResponse;

@RestController
public class SlackBotController {

	@RequestMapping(value = "/slack/slash", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public SlackResponse onReceiveSlashCommand(@RequestParam("team_id") String teamId,
			@RequestParam("team_domain") String teamDomain, @RequestParam("channel_id") String channelId,
			@RequestParam("channel_name") String channelName, @RequestParam("user_id") String userId,
			@RequestParam("user_name") String userName, @RequestParam("command") String command,
			@RequestParam("text") String text, @RequestParam("response_url") String responseUrl) {
		SlackResponse response = new SlackResponse();
		response.setText("Slack Bot");
		response.setResponseType("in_channel");

		Attachment attachment = new Attachment();
		attachment.setText("Hola Mundo");
		attachment.setColor("#0000ff");

		response.getAttachments().add(attachment);

		return response;
	}

}
