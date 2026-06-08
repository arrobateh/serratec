import React from 'react';
import { HeaderContainer, Logo, SearchBar, NavButtons, LoginBtn, RegisterBtn } from './styles';

export default function Header({onLoginClick, onRegisterClick}) {
    return (
        <HeaderContainer>
            <Logo>kick</Logo>
            <SearchBar type="text" placeholder="Buscar..." />
            <NavButtons>
                <LoginBtn onClick={onLoginClick}>Entrar</LoginBtn>
                <RegisterBtn onClick={onRegisterClick}>Cadastrar-se</RegisterBtn>
            </NavButtons>
        </HeaderContainer>
    );
}
