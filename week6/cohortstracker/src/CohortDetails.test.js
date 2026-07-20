import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortsData } from './Cohort';

describe('Cohort Details Component', () => {
    const mockCohort = CohortsData[0];

    test('should create the component', () => {
        const wrapper = shallow(<CohortDetails cohort={mockCohort} />);
        expect(wrapper.exists()).toBe(true);
    });

    test('should initialize the props', () => {
        const wrapper = mount(<CohortDetails cohort={mockCohort} />);
        expect(wrapper.props().cohort).toEqual(mockCohort);
    });

    test('should display cohort code in h3', () => {
        const wrapper = mount(<CohortDetails cohort={mockCohort} />);
        const h3 = wrapper.find('h3');
        expect(h3.text()).toContain(mockCohort.cohortCode);
    });

    test('should always render same html', () => {
        const wrapper = shallow(<CohortDetails cohort={mockCohort} />);
        expect(wrapper).toMatchSnapshot();
    });
});
