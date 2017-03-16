module.exports = (robot) ->
	robot.respond /report status/i, (res) ->
		res.reply "oink oink At your service!"
