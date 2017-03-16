module.exports = (robot) ->
	robot.hear /shit|fuck|scheisse?|säimen/gi, (res) ->
		res.reply "Keine bösen Wörter, Lukas!"
