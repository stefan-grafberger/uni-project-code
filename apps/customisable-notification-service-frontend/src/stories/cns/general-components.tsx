import React from 'react'
import { storiesOf } from '@storybook/react'
import StoryWrapper from '../StoryWrapper'

import LoadingIndicator from '@/modules/shared/components/LoadingIndicator'
import ErrorMessage from '@/modules/shared/components/ErrorMessage'
import BackButton from '@/modules/shared/components/BackButton'
import RuleIcon from '@/modules/shared/components/RuleIcon'

import NextButton from '@/modules/rule-modification/components/NextButton'

import { action } from '@storybook/addon-actions'
import { FormattedMessage } from 'react-intl';
import { handledStatus, messageFromError } from '@/services/response-service'
import { VehicleDataType } from '@/model'

storiesOf('General Components', module)
  .addDecorator(StoryWrapper)
  .add('Small Loading Indicator', () => <LoadingIndicator />, {
    notes: {
      markdown: ` # Loading Indicator
         This indicator is imported directly from material-ui.
      `}
  })
  .add('Large Loading Indicator', () => <LoadingIndicator size={80} />)
  .add('Central Loading Indicator', () => <LoadingIndicator isCentral={true} />)
  .add('Next Button', () => <NextButton onClick={action('Next!')} />)
  .add('Back Button', () => <BackButton onClick={action('Back!')} />)
  .add('Simple Error Message', () =>
    <ErrorMessage message="This is an error message with a string message" />)
  .add('Requests Error Messages', () =>
    <>
      {Object.keys(handledStatus).map((code) =>
        <ErrorMessage key={code}
          message={<> <FormattedMessage id={messageFromError({ status: parseInt(code, 10) })} /> ({code}) </>}
          style={{ marginBottom: '1rem' }} />
      )}
    </>
  )
  .add('Complex Error Message', () =>
    <ErrorMessage message={
      <>
        <span>
          This is an error message
          with a <strong>react node</strong> as message!
          &nbsp;
        </span>
        <LoadingIndicator size={20} color="inherit" />
        <span>&nbsp; 🔥 🔥 </span>
      </>
    } />)
  .add('Rule Icons', () => <>
    {
      Object.values(VehicleDataType).map((vehicleDataType) =>
        <RuleIcon key={vehicleDataType} type={vehicleDataType} />
      )
    }
  </>)
