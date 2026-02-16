from setuptools import setup, find_packages

setup(
    name='apiverve_savingsbonds',
    version='1.1.14',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Savings Bonds provides current and historical rates for US Savings Bonds including Series I (I Bonds) and Series EE bonds. Includes rate components, purchase limits, and comparison recommendations.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/savingsbonds?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
