import {useEffect, useState} from 'react'

import {
    ModalOverlay, LoginCard, LogoContainer, LogoKick, BetaTag, CloseBtn,
    Tabs, TabBtn, InputGroup, PasswordWrapper, ForgotPassword, SubmitBtn, Divider, SocialLogin, SocialBtn
} from './styles';

function LoginModal({onClose, initialTab}) {

    const [activeTab, setactiveTab] = useState(initialTab || 'entrar')
    const [isSubmitted, setSubmitted] = useState(false)

    const [email, setemail] = useState('');
    const [password, setPassword] = useState('');
    const [dataNascimento, setDataNascimento] = useState(new Date().toISOString().split('T')[0]);
    const [usuario, setUsuario] = useState('');

    const [userAuthenticated, setUserAuthenticated] = useState(null);

    async function hashPassword(password) {
        const encoder = new TextEncoder();
        const data = encoder.encode(password);
        const hashBuffer = await crypto.subtle.digest('SHA-256', data);
        const hashArray = Array.from(new Uint8Array(hashBuffer));
        return hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
    }

    const handleLogin = async (event) => {
        event.preventDefault();

        if (!email || !password) {
            alert('Preencha todos os campos!');
            return;
        }

        const hashedPassword = await hashPassword(password);

        if (activeTab === 'cadastrar') {
            setUserAuthenticated({
                email: email,
                password: hashedPassword,
                dataNascimento: dataNascimento,
                usuario: usuario
            });
            alert('Usuário cadastrado com sucesso!')
            setemail('');
            setPassword('');
            setactiveTab('entrar');
        }

        if (activeTab === 'entrar') {
            if (!userAuthenticated) {
                alert('Usuário não encontrado!');
                return;
            }

            const isUserValid = email === userAuthenticated.email || email === userAuthenticated.usuario;
            const isPasswordValid = hashedPassword === userAuthenticated.password;

            if (!isUserValid) {
                alert('Usuario ou Email não encontrado!')
            } else if (!isPasswordValid) {
                alert('Senha incorreta!')
            } else {
                setSubmitted(true);
            }
        }
    };

    useEffect(() => {
        if(isSubmitted) {
            console.log('Usuário autenticado!');
            console.log('Email do usuário: ', userAuthenticated.email);
            console.log('Data de nascimento do usuário: ', new Date(userAuthenticated.dataNascimento + 'T00:00:00').toLocaleDateString('pt-BR'));
            console.log('Usuário do usuário: ', userAuthenticated.usuario);
            console.log('Senha do usuário: ', userAuthenticated.password);

            alert('Login realizado com sucesso!');

            setSubmitted(false)
        }
    }, [isSubmitted, userAuthenticated]);

    return (
        <ModalOverlay>
            <LoginCard>
                <LogoContainer>
                    <LogoKick>KICK<BetaTag>BETA</BetaTag></LogoKick>
                    <CloseBtn onClick={onClose}>&times;</CloseBtn>
                </LogoContainer>

                <Tabs>

                    <TabBtn type="button" $active={activeTab === 'entrar'} onClick={() => setactiveTab('entrar')}>
                        Entrar
                    </TabBtn>
                    <TabBtn type="button" $active={activeTab === 'cadastrar'} onClick={() => setactiveTab('cadastrar')}>
                        Cadastrar-se
                    </TabBtn>
                </Tabs>

                <form onSubmit={handleLogin}>
                    <InputGroup>
                        <label htmlFor="email">
                            {activeTab === 'entrar' ? 'E-mail ou nome de usuário' : 'E-mail'}
                        </label>
                        <input
                            type="text"
                            id="email"
                            autoComplete="off"
                            placeholder={activeTab === 'cadastrar' ? 'you@example.com' : ''}
                            value={email}
                            onChange={(e) => setemail(e.target.value)}
                        />
                    </InputGroup>

                    {activeTab === 'cadastrar' && (
                        <InputGroup>
                            <label htmlFor="date">Data de nascimento</label>
                            <input type="date"
                                   id="date"

                                   value={dataNascimento}
                                   onChange={(e) => setDataNascimento(e.target.value)}
                                    />
                        </InputGroup>
                    )}

                    {activeTab === 'cadastrar' && (
                        <InputGroup>
                            <label htmlFor="usuario">Usuário</label>
                            <input type="text"
                                   id="usuario"
                                   value={usuario}
                                   onChange={(e) => setUsuario(e.target.value)}
                            />
                        </InputGroup>
                    )}

                    <InputGroup>
                        <label htmlFor="password">Senha</label>
                        <PasswordWrapper>
                            <input
                                type="password"
                                id="password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                        </PasswordWrapper>
                        {activeTab === 'entrar' && (
                            <ForgotPassword href="#">Esqueceu sua senha?</ForgotPassword>
                        )}
                    </InputGroup>

                    <SubmitBtn type="submit">
                        {activeTab === 'entrar' ? 'Entrar' : 'Cadastrar-se'}
                    </SubmitBtn>
                </form>

                <Divider><span>ou continue com</span></Divider>

                <SocialLogin>
                    <SocialBtn type="button">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/c/c1/Google_%22G%22_logo.svg" alt="Google"/>
                    </SocialBtn>
                    <SocialBtn type="button">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg" alt="Apple"/>
                    </SocialBtn>
                </SocialLogin>
            </LoginCard>
        </ModalOverlay>
    )
}

export default LoginModal
