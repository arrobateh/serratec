import { createGlobalStyle } from 'styled-components';

export const GlobalStyle = createGlobalStyle`
* {
     margin: 0;
     padding: 0;
     box-sizing: border-box;
     font-family: 'Inter', sans-serif, system-ui;
}

body {
    background-color: #0b0e11;
    color: #ffffff;
    overflow: hidden;
}
`;