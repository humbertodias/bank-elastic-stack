const httpRequest = ({ endpoint, method, data }) => {
  const host = process.env.REACT_APP_LB_HOST || 'localhost';
  const port = process.env.REACT_APP_LB_PORT || 3005;
  const url = new URL(`http://${host}:${port}/${endpoint}`);

  return fetch(url, {
    method,
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
};

export default httpRequest;
