import styled from 'styled-components';

export const HeaderContainer = styled.header`
    grid-area: header;
    background-color: #191b1f;
    border-bottom: 1px solid #24272c;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 20px;
`;

export const Logo = styled.div`
    color: #00e701; 
    font-size: 26px;
    font-weight: 800;
    letter-spacing: -1px;
    cursor: pointer;
`;

export const SearchBar = styled.input`
    background-color: #24272c;
    border: 2px solid transparent;
    border-radius: 6px;
    color: #fff;
    padding: 8px 16px;
    width: 350px;
    font-size: 14px;
    outline: none;

  &:focus {
    border-color: #53fc18;
  }
`;

export const NavButtons = styled.div`
    display: flex;
    align-items: center;
    gap: 16px;
`;

export const LoginBtn = styled.button`
    background: transparent;
    color: #fff;
    border: none;
    font-weight: 600;
    cursor: pointer;
    font-size: 14px;
`;

export const RegisterBtn = styled.button`
    background-color: #00e701;
    color: #000;
    border: none;
    padding: 8px 16px;
    border-radius: 6px;
    font-weight: 700;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.2s;

  &:hover {
    background-color: #53fc18;
  }
`;