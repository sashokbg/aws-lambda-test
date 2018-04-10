'use strict';

exports.handler = (event, context, callback) => {
  let body;
    
  if (event.body !== null && event.body !== undefined) {
      body = JSON.parse(event.body)
  }

	console.log(`Event Name is: ${body.name}`);
	console.log(event);

	callback(null, {
      statusCode: 200,
      body: JSON.stringify(`Hello World from AWS Lambda ${body.name}`)
    }
  );
};
