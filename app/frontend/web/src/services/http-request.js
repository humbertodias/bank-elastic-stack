const httpRequest = ({ port = 3005, endpoint, method, data }) => {
  const lb_host = process.env.REACT_APP_LB_HOST || 'localhost';
  const url = new URL(`http://${lb_host}:${port}/${endpoint}`);

  return fetch(url, {
    method,
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
};

export default httpRequest;
