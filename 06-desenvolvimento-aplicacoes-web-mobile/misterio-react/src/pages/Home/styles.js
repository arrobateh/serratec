import styled from 'styled-components';

export const GridContainer = styled.div`
    display: grid;
    grid-template-rows: 70px 1fr;
    grid-template-columns: 240px 1fr;
    grid-template-areas:
        'header header'
        'sidebar main';
    height: 100vh;
    width: 100vw;
    background-color: #0b0e11;
`;

export const MainContent = styled.main`
    grid-area: main;
    overflow-y: auto;
    padding: 32px;
        display: grid;
        row-gap: 50px;
`;

export const SectionTitle = styled.h2`
    font-size: 20px;
    font-weight: 700;
    margin-bottom: 20px;
    color: #fff;
    
`;

export const StreamGrid = styled.div`
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 20px;
`;