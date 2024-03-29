import React from 'react'
import { addLocaleData, IntlProvider } from 'react-intl';
import de from 'react-intl/locale-data/de';
import en from 'react-intl/locale-data/en';
import { withRouter, RouteComponentProps } from 'react-router'
import { connect, StateMapper } from '@/state/connector'
import { LanguageType } from '@/state/language'
import { languageSelector } from '@/state/selectors'
import { messages } from '@/i18n';

/*
 * This module does not work with react router,
 * and is only here for react-storybook integration
 */

addLocaleData([...en, ...de]);

export interface IntlWrapperAttributes { }
export interface StateAttributes {
  language: LanguageType
}
export type IntlWrapperProps = IntlWrapperAttributes & RouteComponentProps & StateAttributes

const IntlWrapper: React.SFC<IntlWrapperProps> = ({ language, children }) => (
  <IntlProvider
    locale={language}
    textComponent={React.Fragment}
    messages={messages[language]} >
    {children}
  </IntlProvider>
)

const mapStateToProps: StateMapper<IntlWrapperAttributes, StateAttributes> = (state) => ({
  language: languageSelector(state)
})

export default withRouter(connect(mapStateToProps, null, null, { pure: false })(IntlWrapper))
