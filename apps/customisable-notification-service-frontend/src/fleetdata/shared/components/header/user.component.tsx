import { ListItem, Menu } from '@material-ui/core';
import update from 'immutability-helper';
import * as React from 'react';
import { FormattedMessage, InjectedIntlProps, injectIntl } from 'react-intl';
import { Link } from 'react-router-dom'
import { StyledMenuItem } from '@/fleetdata/shared/styled-components/form/form-elements.style';
import { StyledIconButton } from '@/fleetdata/shared/styled-components/icon-button.style';
import { mediumgray, white } from '@/fleetdata/shared/styles/variables';
import styled from 'styled-components';
import AvatarIcon from '../icons/avatar.icon';

const StyledMenu = styled(Menu)`
  z-index: 9200;
`;

const StyledUserMenuItem = styled(StyledMenuItem)`
  padding: 11px 24px;
`;

const StyledUserListItem = styled(ListItem)`
  &:focus {
    outline: none;
  }
`;

const StyledSeparator = styled.hr`
    margin: 0;
    border-color: ${white};
    border-style: solid;
    border-width: 3px;
`;

const StyledUserMenuIconButton = styled(StyledIconButton)`
  margin-top: -5px;
`;

const StyledUserName = styled.div`
    color: ${mediumgray};
`;

interface IState {
  buttonRef: HTMLButtonElement | null;
  menuOpen: boolean;
}

interface IProps {
  // openChangePasswordDialog: () => void;
  // logout: () => void;
  userName?: string;
}

class UserComponent extends React.Component<
  IProps & InjectedIntlProps,
  IState
  > {
  // Set default props
  public static defaultProps = {
    userName: 'Erika Musterfrau',
  };

  public state = {
    buttonRef: null,
    menuOpen: false,
  };

  public openMenu = (event: React.MouseEvent<HTMLButtonElement>) => {
    const target = event.currentTarget;
    this.setState((prevState: IState) =>
      update(prevState, {
        menuOpen: { $set: true },
        buttonRef: { $set: target },
      }),
    );
  };

  public closeMenu = () =>
    this.setState((prevState: IState) =>
      update(prevState, {
        menuOpen: { $set: false },
        buttonRef: { $set: null },
      }),
    );

  public handleMenuClick = (e: React.MouseEvent<HTMLElement>) => {
    switch (
    ((e.target as unknown) as {
      getAttribute: (x: string) => string;
    }).getAttribute('value')
    ) {
      case 'changePassword':
        // this.props.openChangePasswordDialog();
        break;
      case 'logout':
        // this.props.logout();
        break;
    }
    this.closeMenu();
  };

  public render() {
    return (
      <>
        <StyledUserMenuIconButton onClick={this.openMenu}>
          <AvatarIcon width={24} height={24} />
        </StyledUserMenuIconButton>
        <StyledMenu
          open={this.state.menuOpen}
          onClick={this.handleMenuClick}
          anchorEl={this.state.buttonRef!}
          getContentAnchorEl={undefined}
          onClose={this.closeMenu}
          anchorOrigin={{
            vertical: 'bottom' as 'bottom',
            horizontal: 'left' as 'left' | 'right',
          }}
        >
          <StyledUserListItem>
            <StyledUserName>{this.props.userName}</StyledUserName>
          </StyledUserListItem>
          <StyledSeparator />
          <StyledUserMenuItem value="cns">
            <Link to="/" style={{ textDecoration: 'none', color: 'inherit' }}>
              <FormattedMessage id="cns.user.settings.label" />
            </Link>
          </StyledUserMenuItem>
          <StyledUserMenuItem value="changePassword">
            <FormattedMessage id="userMenu.changePassword" />
          </StyledUserMenuItem>
          <StyledSeparator />
          <StyledUserMenuItem value="logout">
            <FormattedMessage id="userMenu.logout" />
          </StyledUserMenuItem>
        </StyledMenu>
      </>
    );
  }
}

export const User = injectIntl(UserComponent);
