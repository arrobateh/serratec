import styled from 'styled-components';

export const ModalOverlay = styled.div`
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, 0.7);
    display: flex;
      align-items: center;
    justify-content: center;
    z-index: 9999;
`;

export const LoginCard = styled.div`
    background-color: #191b1f;
    border: 1px solid #24272c;
    padding: 32px;
    border-radius: 8px;
    width: 100%;
    max-width: 480px;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.5);
    display: flex;
    flex-direction: column;
    color: #fff;
`;

export const LogoContainer = styled.div`
    font-size: 32px;
    font-weight: 900;
    margin-bottom: 30px;
    letter-spacing: -1px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    color: #53fc18;
    width: 100%;
`;

export const LogoKick = styled.span`
    position: relative;
    display: inline-block;
`;

export const BetaTag = styled.span`
    position: absolute;
    top: 2px;
    left: 102%;
    font-size: 7px;
    color: #adb5db;
`;

export const CloseBtn = styled.button`
    background: none;
    border: none;
    color: #adb5db;
    font-size: 24px;
    cursor: pointer;
    border-radius: 4px;
    line-height: 1;
    padding: 4px 8px;

  &:hover {
    background: #2d3139;
  }
`;

export const Tabs = styled.div`
    display: flex;
    gap: 20px;
    border-bottom: 1px solid #2d3139;
    margin-bottom: 25px;
`;

export const TabBtn = styled.button`
    background: none;
    border: none;
    color: ${props => props.$active ? '#53fc18' : '#efeff1'};
    font-size: 16px;
    font-weight: 600;
    cursor: pointer;
    padding-bottom: 10px;
    border-bottom: ${props => props.$active ? '2px solid #53fc18' : '2px solid transparent'};

  &:hover {
    color: #53fc18;
  }
`;

export const InputGroup = styled.div`
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
    width: 100%;

  label {
    font-size: 14px;
    font-weight: 600;
    margin-bottom: 8px;
    color: #efeff1;
  }

  input {
    background-color: #0b0e11;
    border: 1px solid #2d3139;
    border-radius: 6px;
    padding: 12px;
    color: white;
    font-size: 14px;
    width: 100%;
    transition: border-color 0.1s ease;

    &:focus {
      outline: none;
      border-color: #53fc18;
    }

    &:hover {
      border-color: #53fc18;
    }
  }
`;

export const PasswordWrapper = styled.div`
    position: relative;
    display: flex;
    flex-direction: column;
`;

export const TogglePassword = styled.button`
    position: absolute;
    right: 12px;
    top: 12px;
    background: none;
    border: none;
    color: #adb5db;
    cursor: pointer;
`;

export const ForgotPassword = styled.a`
    color: #adb5db;
    font-size: 12px;
    text-decoration: none;
    align-self: flex-end;
    margin-top: 6px;

  &:hover {
    text-decoration: underline;
  }
`;

export const SubmitBtn = styled.button`
    background-color: #53fc18;
    color: #000000;
    border: none;
    border-radius: 6px;
    width: 100%;
    padding: 14px;
    font-size: 16px;
    font-weight: 700;
    cursor: pointer;
    margin-top: 10px;
    transition: background 0.2s;

  &:hover {
    background-color: #46d314;
  }
`;

export const Divider = styled.div`
    display: flex;
    align-items: center;
    text-align: center;
    color: #adb5db;
    font-size: 12px;
    margin: 25px 0;
    width: 100%;

  &::before, &::after {
    content: '';
    flex: 1;
    border-bottom: 1px solid #2d3139;
  }

  &:not(:empty)::before { margin-right: .5em; }
  &:not(:empty)::after { margin-left: .5em; }
`;

export const SocialLogin = styled.div`
    display: flex;
    justify-content: center;
    gap: 15px;
    width: 100%;
`;

export const SocialBtn = styled.button`
    background-color: #2d3139;
    border: none;
    border-radius: 6px;
    width: 40px;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;

  img {
    width: 20px;
    height: 20px;
  }

  &:hover {
    background-color: #3d434e;
  }
`;