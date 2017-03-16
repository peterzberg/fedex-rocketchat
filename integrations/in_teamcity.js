/* exported Script */
/* globals console, _, s */

/** Global Helpers
 *
 * console - A normal console instance
 * _       - An underscore instance
 * s       - An underscore string instance
 */

class Script {
  /**
   * @params {object} request
   */
  process_incoming_request({ request }) {
    // request.url.hash
    // request.url.search
    // request.url.query
    // request.url.pathname
    // request.url.path
    // request.url_raw
    // request.url_params
    // request.headers
    // request.user._id
    // request.user.name
    // request.user.username
    // request.content_raw
    // request.content

    // console is a global helper to improve debug
    console.log(request.content);
    var success = request.content.build_result === "success";
    var color = success ? "#00FF00" : "#FF0000";
    var buildUrl = request.content.build_status_url.replace(/teamcity/g, 'localhost');
    var text =  success ? "Nix zu tun" : "Hey Alter, fix mal den Build";
    return {
      content:{
        "icon_url": "https://inedo.com/den/logos/TeamCity-large.png",
        "text": request.content.build_name + " - Status: " + request.content.build_result,
        "attachments": [{
           "color": color,
           "title": "Link zu Build",
           "title_link": buildUrl,
           "text": text,
         }]
       }
    };

    // return {
    //   error: {
    //     success: false,
    //     message: 'Error example'
    //   }
    // };
  }
}
